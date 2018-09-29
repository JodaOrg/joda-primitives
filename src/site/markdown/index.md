## <i></i> About

**Joda-Primitives** provides collections and utilities to bridge the gap between objects
and primitive types in Java.

The standard Java collections API only operates on reference types, not primitives, like `int`.
This project provides interfaces and implementations for primitives.

Joda-Primitives is licensed under the business-friendly [Apache 2.0 licence](licenses.html).


## <i></i> Features

Primitive implementations are provided for:

* Collection
* List
* Iterable
* Iterator
* ListIterator


## <i></i> Documentation

Various documentation is available:

* The [Javadoc](apidocs/index.html)
* The [change notes](changes-report.html) for each release
* The [GitHub](https://github.com/JodaOrg/joda-primitives) source repository


---

## <i></i> Why Joda Primitives?

Joda-Primitives provides collections based around storage in primitive array objects such as `int[]`.
By contrast, the JDK collections store data as Objects, for example of type `Integer`.

When you add an `int` to a JDK collection, the compiler silently creates an box using `Integer.valueOf(n)`.
And when you retrieve the value, the compiler silently calls the `.intValue()` method.
By avoiding this object creation, Joda-Primitives collections are much faster, use much less memory
and create less garbage than equivalent boxed collections.

Interfaces and implementations are provided for each primitive type.
The interface has additional dedicated methods relevant to the primitive type.
See the [Javadoc](apidocs/index.html) for more details.

This project is an offshoot of <a href="https://commons.apache.org/proper/commons-primitives/">Commons Primitives</a>.
The two projects have very different designs.
Commons Primitives defines interfaces independent of the JDK collection interfaces.
Joda-Primitives defines interfaces that extend the JDK collection interfaces.
This project offers deeper direct integration, however this results in certain method names
being different from JDK collections.


---

## <i></i> Releases

[Release 1.0](download.html) is the current latest release.
This release is considered stable and worthy of the 1.x tag.

Joda-Primitives requires Java SE 5 or later and has [no dependencies](dependencies.html).

Available in [Maven Central](https://search.maven.org/search?q=g:org.joda%20AND%20a:joda-primitives&core=gav).

```xml
<dependency>
  <groupId>org.joda</groupId>
  <artifactId>joda-primitives</artifactId>
  <version>1.0</version>
</dependency>
```

---

### Support

Support on bugs, library usage or enhancement requests is available on a best efforts basis.

To suggest enhancements or contribute, please [fork the source code](https://github.com/JodaOrg/joda-primitives)
on GitHub and send a Pull Request.

Alternatively, use GitHub [issues](https://github.com/JodaOrg/joda-primitives/issues).
