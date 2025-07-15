# SearchableSpinnerView

A custom Android view that provides a searchable dropdown spinner functionality. This view combines a Material Design TextInputLayout with a ListView to create a user-friendly searchable spinner component.

## Features

- Material Design compatible TextInputLayout
- Real-time search filtering
- Case-insensitive search
- Customizable item selection callback
- Clean and modern UI
- Easy integration
- Edge-to-edge support
- Built-in error handling
- Support for RTL layouts
- Customizable styling
- Lightweight implementation

## Requirements

- Android SDK 26+
- Material Design components
- Kotlin 1.8+
- AndroidX dependencies

## Installation

### 1. Configure JitPack Repository
Before adding the dependency, you need to configure the JitPack repository in your project's `settings.gradle.kts` file:

```kotlin
pluginManagement {
    repositories {
        // ... other repositories
        maven { url = uri("https://jitpack.io") }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        // ... other repositories
        maven { url = uri("https://jitpack.io") }
    }
}
```

### 2. Add the Dependency
Add the following dependency to your app's build.gradle.kts file:

```kotlin
dependencies {
    implementation("com.github.yashraiyani098:SpinnerTestingLibrary:v1.0")
}
```

## Usage

### 1. Add to Layout
Add the SearchableSpinnerView to your layout XML:

```xml
<com.ext.searchablespinnerview.SearchableSpinnerView
    android:id="@+id/searchableSpinner"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"/>
```

### 2. Initialize in Activity/Fragment

```kotlin
// Get the view
val searchableSpinner = findViewById<SearchableSpinnerView>(R.id.searchableSpinner)

// Set items (List of String)
searchableSpinner.setItems(listOf("lion", "leopard", "buffalo", "cow", "dog"))

// Set item selection listener
searchableSpinner.setOnItemSelectedListener { selectedItem ->
    // Handle item selection
    println("Selected item: $selectedItem")
}

// Get selected item
val selectedItem = searchableSpinner.getSelectedItem()
```

## Customization

The SearchableSpinnerView uses Material Design components and can be customized using standard Material Design attributes. You can customize:

- Hint text (using android:hint attribute)
- Text colors (using app:errorTextColor, app:helperTextColor, etc.)
- Background colors
- Input type
- Layout dimensions
- Error message text
- Helper text
- Text size and style
- Icon tint
- Box background color
- Box stroke color
- Box corner radius

### Customizing Material Design Attributes

```xml
<com.ext.searchablespinnerview.SearchableSpinnerView
    android:id="@+id/searchableSpinner"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:hint="Search items"
    app:boxBackgroundColor="@color/white"
    app:boxStrokeColor="@color/black"
    app:boxStrokeWidth="1dp"
    app:boxCornerRadius="8dp"
    app:errorTextColor="@color/red"
    app:helperTextColor="@color/grey"/>
```

## How it works

1. The view contains a TextInputLayout with an EditText for search input
2. A ListView is shown below when typing starts
3. Items are filtered in real-time as you type
4. Clicking on an item selects it and hides the suggestions list

## Contributing

1. Fork the repository
2. Create your feature branch
3. Commit your changes
4. Push to the branch
5. Create a new Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details
