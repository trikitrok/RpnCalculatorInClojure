# rpn

Reverse Polish Notation calculator kata

Useful info:

[Reverse Polish Notation algorithm explanation](http://mathworld.wolfram.com/ReversePolishNotation.html)

[Online Reverse Polish Notation Calculator](http://www.meta-calculator.com/learning-lab/reverse-polish-notation-calculator.php) to check your results.

The project uses [Midje](https://github.com/marick/Midje/).

## How to run the tests

`lein midje` will run all tests.

`lein midje namespace.*` will run only tests beginning with "namespace.".

`lein midje :autotest` will run all the tests indefinitely. It sets up a
watcher on the code files. If they change, only the relevant tests will be
run again.
