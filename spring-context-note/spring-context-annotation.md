## ClassPathScanningCandidateComponentProvider

(348)
1. getRegistry() return的 BeanDefinitionRegistry從哪裡來的還不知道
2. ResourcePatternResolver是一種ResourceLoader, setResourceLoader()中接收一個resourceLoader並作為ResourcePatternUtils.getResourcePatternResolver()的parameter,
如果傳入的ResourceLoader已經有實現ResourcePatternResolver則會回傳原ResourceLoader, 否則會將其包成ResourcePatternResolver的實現再回傳
3. getResourcePatternResolver()如果this.resourcePatternResolver是空，則assign一個PathMatchingResourcePatternResolver作為default
4. metadataReaderFactory的default是CachingMetadataReaderFactory
5. includingFilters中的內容是會去scan的annotations, 預設有@Component類型的annotation和Jakarta, javax支援的annotation
6. 核心的method是findCandidateComponents，會回傳一個Set<BeanDifinitions>來讓其他module initiate，如果componentsIndex和including/excluding filters可用
會在該index中找includeFilters中有match的filter的stereotype，用metadataReader讀出來後看是不是candidateComponent, 是的話就加入return Set中;
若index和filters不能用，就只能scan整個base package。會先resolve base package的格式，之後resourcePatternResolver去找出每個resource, 用metadataReader讀出來之後看是不是candidateComponent,
是的話就加入return Set中
7. 目前componentIndex已經是deprecated, 所以是不能用的
8. isCandidateComponent: 先排除在excludeFilter中和不在includeFilter中的，然後再看Condition需不需要skip

## ClassPathBeanDefinitionScanner

(152)
1. extend ClassPathScanningCandidateComponentProvider，並且主要多了一個BeanDefinitionRegistry，除了可以scan component以外也可以register component到傳入的registry
2. postProcessBeanDefinition指的是set autowire candidate在bean definition上，post process指的是@Autowire
3. scan()中呼叫doScan()只是為了它的side effect而不是為了獲得其returned value
4. doScan()主要會檢查要註冊的bean是否已經在registry中，如果已經存在則是source是否一樣、是否compatible
5. 此class的constructor透過this()來層層傳遞，做到根據條件設定default值

## CommonAnnotationBeanPostProcessor

(667)
1. 支援一般不屬於spring-framework的annotation的BeanPostProcessor實現
	當mappedName有值時，這個class會使用JNDI來找resource, 而如果alwaysUseJndiLookup = true的話即使mappedName沒有值也會使用JNDI
2. BeanPostProcessor是一個interface, 含有兩個method: 
	1.進行在Bean初始化之前的行為 
	2. 進行在Bean初始化之後的行為
所謂PostProcessor是指在Bean創建之後，而BeanPostProcessor是被applicationContext auto detect且註冊到container中的
3. CommonAnnotationBeanPostProcessor繼承InitDestroyAnnotationBeanPostProcessor來支援init annotation (AfterConstruct)和destroy annotation (BeforeDestroy)來執行方法
4. CommonAnnotationBeanPostProcessor預設由XML中的"context:annotation-config" 和 "context:component-scan" tag來註冊
5. @Resource, @WebServiceRef, @EJB等annotation都依賴JNDI來尋找並inject
6. field: resourceAnnotationTypes是一個用來存所有支援的resource annotation type的Set，當找到一個resource時會去看他的annotation type是否在這個Set中
7. resourceFactory和beanFactory通常是spring container中的同一個Bean Factory, resouceFactory通常只是一個用來查找resouce的別名
8. 在spring中的bean如果有inherits其他bean, 則會有merge bean definition的動作，如果沒有merge則child bean不會繼承parent bean
9. bean lifecycle:
	* Bean definition parsing and registration
	* Bean definition merging - create RootBeanDefinition
	* Post-processing merged bean definition
	* Bean instanitation - create bean instance using RootBeanDefinition
	* Dependency Injection
	* Bean Initialization - calls "postProcessBeforeInitialization" and "postProcessAfterInitialization"
10. Ahead-of-Time (AOT): 讓應用程式的特定bean在compile time就先compute，使startup的performance提升; processAheadOfTime是負責準備metadata和其他AOT compliation需要的資訊,而這個class也利用AOT來加速
11. 這個class的流程
	* CommonAnnotationBeanPostProcessor在applicationContext上被註冊為一個bean post-processor
	* postProcessMergedBeanDefinition方法被呼叫，讓merged bean definition能夠被處理
	* findResourceMetadata方法掃描bean class中的annotation來創建InjectionMetadata物件 (其中包含Collection<InjectionElement>)，並被加入到injectinoMetadataCache中
	* 在bean instantiation階段，postProcessProperties方法被呼叫，將InjectionMetadata inject到bean中,後使用InjectionMetadata呼叫getResource和autowireResource來inject實際的resource
	* 進入bean的life cycle, 依據annotation來在特定lifecycle執行特定任務
	* 如果AOT可用，則在compile time processAheadOfTime方法會被呼叫，會precompute metadata來讓injection快一點
12. LookupElement inner class用來表示一個之後需要被Lookup resource的element (field或method)
13. ResourceElement inner class是一個特別用於@Resource的LookupElement
14. LegacyResourceElement inner class是用於處理舊版本的@Resource
15. EjbRefElement inner class是一個特別用於@EJB的LookupElement

## ComponentScanAnnotationParser

(85)
1. 用來parse @ComponentScan這個annotation
2. 主要透過parse這個method, 這個method透過parameter AnnotationAttributes componentScan來獲取該annotation的設定
3. AnnotationAttributes透過extend LinkedHashMap<String, Object>來作為一個儲存annotation attributes的type, 其中的key會是annotation attribute的名稱，而value則透過reflection機制populate進去
4. parse中先根據annotation attributes來創建並配置ClassPathBeanDefinitionScanner, 最後會呼叫scanner的doScan方法並回傳其結果, scan的packages即為其中一個attribute: basePackages的值(String)
5. parse的最後在加入excludeFIlter時scanner.addExcludeFilter使用了anonymous inner class的方式來將一個本不可instantiate的abstract class中的方法override掉

## ComponentScanBeanDefinitionParser

(215)
1. 與ComponentScanAnnotationParser相似，但是用來parse <context:component-scan>這個XML tag
2. 還要多registerComponents (register infrastructure beans: ConfigurationClassPostProcessor, AutowiredAnnotatinoBeanPostProcessor)才能做annotation processing

## Condition
1. 是一個interface, 其中的matches方法用於給其他Iimplement的custom Condition override
2. Conditional這個annotation接收這個interface的多個generic type, 要滿足該generic type所override的matches才會將該class註冊成bean
3. matches的parameter(ConditionContext, AnnotatedTypeMetadata)都是由spring framework提供
4. @Conditional可以被標註在class或是method上，在spring中如果一個method被標註@Bean，spring會把該method的return value註冊成一個bean

## ConditionContext
1. 提供matches實作一些context資訊像是registry, beanFactory, environment, resourceLoader和classLoader

## ConditionEvaluator
1. 包含一個ConditionContext的實作類ConditionContextImpl, 這個class會推論(deduce)出該context的registry, beanFactory, environment, resourceLoader, classLoader
2. 會透過shouldSkip method來判斷是否需要將classes註冊為bean
3. collectConditions從metadata中找出該class/method上的所有condition
4. 是實際處理@Conditional的地方

## ReflectiveScan
1. 提供scan @Reflective功能的annotation
2. @Reflective可以標註在class/method/constructor/field等上，用於標示在runtime reflection中需要可用的物件, intend for AOT

## ResourceElementResolver
1. 一個用於在不使用JNDI的情況下解析resource element (field或method)並injection的abstract class,可以resolve或resolveAndSet
2. 被ResourceFieldResolver和ResourceMethodResolver繼承
3. process:
    * 先透過forField或是forMethod來取得resolve特定field/method的Resolver
    * 再呼叫不同實現中的resolveAndSet
    * 在resolveAndSet中會呼叫resolve, 再由resolve呼叫resolveValue
4. LookupDependencyDescriptor用在resolve dependency的時候

## Role
1. 一個用來表示type/method的角色的annotation,主要是用來幫助分類和管理

## ScannedGenericBeanDefinition
1. 用來表示一個被scanned的bean definition
2. constructor傳入一個metadata reader,用此metadata reader來得到metadata

## Scope
1. 用來決定一個bean的scope, 有singleton和prototype兩種
2. prototype: create a new instance on each request
3. proxy mode: 用來解決singleton bean associate with prototype bean的問題

## TypeFilterUtils
1. #createTypeFiltersFor 根據＠ComponentScan.Filter中的filter type enum值來決定創建哪些種類的filters到includeFilters和excludeFilters
