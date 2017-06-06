# Template Engine Kata

Write a "template engine" meaning a way to transform template strings, `"Hello {$name}"` into "instanced" strings. 
To do that a variable->value mapping must be provided. For example, if `name="Pietro"` and the template string is `"Hello {$name}"` the result would be `"Hello Pietro"`.

### Should evaluate template single variable expression
```Java
mapOfVariables.put("name","Pietro");
templateEngine.evaluate("Hello {$name}", mapOfVariables)
```
=>   should evaluate to "Hello Pietro"

### Should evaluate template with multiple expressions:

```Java
mapOfVariables.put("firstName","Pietro");
mapOfVariables.put("lastName","Di Bello");
templateEngine.evaluate("Hello {$firstName} ${lastName}", mapOfVariables);
```
=>   should evaluate to "Hello Pietro Di Bello"

### Should give error if template variable does not exist in the map:

map empty
```Java
templateEngine.evaluate("Hello {$firstName} ", mapOfVariables);
```
=>   should throw `MissingValueException`

### Should evaluate complex cases:

```Java
mapOfVariables.put("name","Pietro");
templateEngine.evaluate("Hello ${$name}}", mapOfVariables);
```
=>   should evaluate to "Hello ${Pietro}"

Example origin is Koskela's book
http://www.amazon.com/Test-Driven-Acceptance-Java-Developers/dp/1932394850
