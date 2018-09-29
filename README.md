Joda-Primitives
---------------

Joda-Primitives provides collections and utilities to bridge the gap between objects and primitive types in Java.

Current interfaces and implementations include:

- Collection
- List
- Iterable
- Iterator
- ListIterator

Each collection implementation stores the data as a primitive object.
The interfaces provide dedicated methods to access those primitives.
If you need a list of numbers or booleans, then these classes are ideal.
A primitive collection uses less memory, performs more quickly and saves on garbage collection.
All this is due to the fact that no Object wrapper class has to be created.

This project is an offshoot of Commons Primitives.
The two projects have very different designs.
Commons Primitives defines interfaces independent of the JDK collection interfaces.
Joda-Primitives defines interfaces that extend the JDK collection interfaces.
This project offers deeper direct integration, however this results in certain method
names being different from JDK collections.

Joda-Primitives is licensed under the business-friendly [Apache 2.0 licence](https://www.joda.org/joda-primitives/licenses.html).


### Documentation
Various documentation is available:

* The [home page](https://www.joda.org/joda-primitives/)
* The [Javadoc](https://www.joda.org/joda-primitives/apidocs/index.html)
* The [FAQ](https://www.joda.org/joda-primitives/faq.html) list
* The change notes for the [releases](https://www.joda.org/joda-primitives/changes-report.html)


### Releases
[Release 1.0](https://www.joda.org/joda-primitives/download.html) is the current latest release.
This release is considered stable and worthy of the 1.x tag.
It depends on JDK 1.6 or later.

Available in the [Maven Central repository](https://search.maven.org/search?q=g:org.joda%20AND%20a:joda-primitives&core=gav)


### Support
Please use GitHub issues and Pull Requests for support.
