## EmbeddedValueResolverSupport
* 支援resolve像是@Value(${catalog.name})這種placeholder的解析,其中的catalog.name在application.properties中定義
* 實現EmbeddedValueResolverAware並implements setEmbeddedValueResolver()方法來設定解析器 (如此讓這個support獲得EmbeddedValueResolver)

## FileSystemXmlApplicationContext
* 很多層extended的一種applicationContext
* 用於使用xml config file來配置application context

## GenericApplicationContext
* implements BeanDefinitionRegistry是為了要可以混合使用xml和annotation的方式來註冊bean (關鍵在使用BeanDefinition來註冊,而不像其他application context使用特定的scanner或是xml file reader來獲得BeanDefinition)
* 可以做AOT (#refresh -> #refreshForAotProcessing)
* beanFactory就是IoC container的重點
* 最常見的applicationContext之一
* 只能refresh一次,確保bean的status, lifecycle正常也比免重複load resource
* 其他做的事情就像一般applicationContext一樣(get/set beanFactory, resourceLoader, classLoader, register bean等)

## GenericGroovyApplicationContext
(85)
* extends `GenericApplicationContext`, implements `GroovyObject`, 在GenericApplicationContext的基礎上添加使用Groovy配置application和bean的支援
* 使用GroovyBeanDefinitionReader

## GenericXmlApplicationContext
(46)
* extends `GenericApplicationContext`, 添加使用xml配置application context和bean的支援
* 使用XmlBeanDefinitionReader

## MessageSourceAccessor
(57)
* 提供取得MessageSource中message的getMessage方法, 並且有多個overloading #getMessage

## MessageSourceResourceBundle
(49)
* 讓MessageSource可以作為一個java.util.ResourceBundle,在JSTL web view中很好用
* ResourceBundle: 一個manage locale-specific data的java class
* JSTL web view: Javaserver pages Standard Tag Library, 提供jsp使用的Tag

## MessageSourceSupport
(54)
* 如果要創建一個concrete MessageSource, 則要extends AbstractMessageSource, 而AbstractMessageSource extends MessageSourceSupport, implements MessageSource
* Provides utility methods for message formatting and argument resolution

## PostProcessorRegistrationDelegate
(363)
* register and invoke various postProcessors in applicationContext
* 在AbstractApplicationContext的#invokeBeanFactoryPostProcessors和#registerBeanPostProcessors delegate給這個class的這兩個method
* 主要就是提供#invokeBeanFactoryPostProcessors和#registerBeanPostProcessors的delegate實作, manage beanFactoryPostProcessor和beanDefinitionRegistryPostProcessor並register BeanPostProcessors
* 會根據PriorityOrdered和Ordered的順序來正確的invoke postProcessors
* #invokeBeanFactoryPostProcessors流程：
```
1. 把所有bean拿出來,找出有implement BeanPostProcessor interface的bean,表示這些bean是一個post processor
2. 先把beanDefinitionRegistryPostProcessor的這些post processor拿出來invoke, 因為這些post processor可能修改了bean的definition
3. 再把一般的beanFactoryPostProcessor拿出來根據order sort之後一一invoke
**在invoke beanFactoryPostProcessor的時候有可能動態註冊了更多 beanFactoryPostProcessor, 所以要recursive處理它
```
* #registerBeanPostProcessors流程:
```
按照Priority -> ordered -> regular來註冊
```
* 要先做beanFactoryPostProcessor再註冊BeanPostProcessor, 因為beanFactoryPostProcessor涉及到的是關於bean definition和spring container配置的新增和修改

## PropertySourcePlaceholderConfigurer
(104)
* 一種PlaceholderConfigurerSupport, 專門用於解析bean definition和@Value中的`${...}`, 並且依據當前spring Environment的PropertySources來替換
* 是一個beanFactoryPostProcessor,用於修改bean的definition. 主要提供#postProrcessBeanFactory
* implement EnvironmentAware讓它必須要持有一個Environment來取得PropertySources

## ReloadableResourceBundleMessageSource
(404)
* 根據.properties或是.xml來將不同語言的翻譯load進來
```
# English
greeting=hello

# Chinese
greeting=你好
```
* 提供cache和reload功能,可以設定是否concurrentRefresh（一個thread還在呈現原本的,另一個thread在reload）
* 會將多個properties組合(merge)成一個resource bundle, 並且可以根據locale來load不同語言的翻譯
* 使用key-value來獲得 (ex: messageSource.getMessage("greeting", null, locale.zh_TW) -> "你好")

## SimpleThreadScope
(44)
* 一種scope, 裡面有一個放在ThreadLocal中的Map, 可以get和remove Map中的Object

## StaticApplicationContext
(52)
* extends GenericApplicationContext
* programmatically: 透過code直接建立beans, 而不需要透過xml或其他檔案來得到bean definition

## StaticMessageSource
(78)
* 就是一個Map<String, Map<Locale, MessageHolder>>的class, 主要用於測試
* 提供add, get, resolve等等method
