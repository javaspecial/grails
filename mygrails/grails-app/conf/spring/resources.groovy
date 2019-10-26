// Place your Spring DSL code here
beans = {
    xmlns aop:"http://www.springframework.org/schema/aop"
    aspectBean(aop.AOP)
    aop.config("proxy-target-class":true) {}
}
