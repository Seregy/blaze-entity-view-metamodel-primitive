## Blaze Persistence Entity View metamodel filtering issue example

This is an example application for reproducing the issue with Blaze Persistence Entity View
metamodel containing the code that can't be compiled due to the usage of built-in attribute filters
on primitive fields.

Try building the project with Maven to reproduce the issue, it should fail
compiling `CatSimpleViewRelation`, `CatSimpleViewMultiRelation` and `CatSimpleView_` due to
unexpected type.

The project is based on the entity view sample archetype with some changes to the `CatSimpleView`
that demonstrate the current behavior with `@AttributeFilter`.
