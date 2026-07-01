# Workflow: Adding Plugins or Dependencies

## First

Determine whether you are adding a plugin or a dependency. Plugins are used to
extend the build system, while dependencies are libraries that your project
needs to compile and run.

## Plugins

### Locate plugin

Find the plugin on the [Maven Central Repository](https://search.maven.org/) or
the [Gradle Plugin Portal](https://plugins.gradle.org/), or even its own
website. Make sure to check the plugin's documentation for the correct id and
version.

### add plugin to the build script

Open your `build.gradle.kts` file and add the plugin to the `plugins` block. For
example:

```kotlin

plugins {
    id("com.example.plugin") version "1.0.0"
}
```
