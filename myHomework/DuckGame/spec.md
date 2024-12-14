# Duck game specification

* Four types of commands
```
Duck [duck type] [flyable (true/false)]
DynamicBehave [duck type] [dynamic action (swim/fly)]
StaticBehave [duck type] [static action (quack/slient/squeak)]
Display
```

* Output
```
After each `Display` command, display the status of the all duck, for example:
MallardDuck : swim / quack
(The output order should be the same as the duck input order)

DynamicBehave and StaticBehave commands will change the action the duck is doing. Default all the ducks are swimming and slient.

If a duck can not fly and it receives a fly command, it keep swimming and you should print below line.
ex: [Behavior Invalid] RubberDuck can not fly.
```

* Comments
```
[duck type] is restricted to be "MallardDuck", "RedheadDuck", "RubberDuck" and "DecoyDuck
[dynamic action] is restricted to be "swim" and "fly
[static action] is restricted to be "quack", "slient" and "squeak
```
