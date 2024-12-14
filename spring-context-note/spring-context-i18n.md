## LocaleContext
()
1. 提供getLocale()方法

## LocaleContextHolder
1. 用於將LocaleContext和當前thread綁定
2. 作為spring中LocaleContext的中央持有者, 所有method都是static 

## SimpleLocaleContext
1. implement `LocaleContext`
2. 比 `LocaleContext`多了一個Locale field

## SimpleTimeZoneAwareLocaleContext
1. extends `SimpleLocaleContext`
2. 比 `SimpleLocaleContext`多了一個TimeZone field
3. implements `TimeZoneAwareLocaleContext`

## TimeZoneAwareLocaleContext
1. extends `LocaleContext`
2. 只有一個getTimeZone()方法的interface, 目的與Aware類一樣,強迫implements的class具有一個TimeZone field

---
暫結: LocaleContext是最抽象的Layer, SimpleLocaleContext和SimpleTimeZoneAwareLocaleContext是其concrete class

## LocaleContextThreadLocalAccessor
1. An implementation of ThreadLocalAccessor for LocaleContext
2. ThreadLocalAccessor:一個用來存取ThreadLocal中變數的class

## LocaleContextThreadLocalAccessor
1. 用於呼叫LocaleContextHolder的static method 並 return LocaleContext
