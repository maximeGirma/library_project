# Library Project

# Java

Head to the previous repo we developed earlier this week. A Google Drive link will be soon added in this repo

# SWT Examples

## Excerpt

Despite its age, this library is one of the most powerful for Java you can found. Various examples can be found online. The main doc is available at [Eclipse's](https://www.eclipse.org/swt)

## Tips to implement graphical pattern

Since MVC can be a little tricky in this implementation (the overall app does not requires the same amount of MVC than a webapp for instance). I propose to implement a React-like behaviour.

To do so, here is a little list of thing to do to implement such a feature :

- you'll need an interface which will let the implementing classes to provide (have a methode returning) :
  - a Graphical SWT Component
  - destroy / free themself

- then create an abstract class implementing it
- this class will manage a list (or not) of possible children. Thise children will be typed as the interface you declared earlier
- then, create classes corresponding to your "parts" of the app, each one extends the abstract component from earlier
- if they require sub views, they will append them to their "parent" class

And do not forget to write the according UML representation of the app :

- the main packages
- the main use cases (which will lead to your "wireframes" representation)
- the class diagrams
