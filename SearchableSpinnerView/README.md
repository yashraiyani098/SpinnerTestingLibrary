# SearchableSpinnerView

A custom Android view that provides a searchable dropdown spinner functionality. This view combines a Material Design TextInputLayout with a ListView to create a user-friendly searchable spinner component.

## Features

- Material Design compatible TextInputLayout
- Real-time search filtering
- Case-insensitive search
- Customizable item selection callback
- Clean and modern UI
- Easy integration

## Requirements

- Android SDK 21+
- Material Design components

## Usage

### 1. Add the dependency
Add the following dependency to your app's build.gradle file:

```gradle
implementation project(':SearchableSpinnerView')
```

### 2. Add to your layout

```xml
<com.ext.searchablespinnerview.SearchableSpinnerView
    android:id="@+id/searchableSpinner"
    android:layout_width="match_parent"
    android:layout_height="wrap_content" />
```

### 3. Initialize in your Activity/Fragment

```kotlin
// Get the view
val searchableSpinner = findViewById<SearchableSpinnerView>(R.id.searchableSpinner)

// Set items
searchableSpinner.setItems(listOf("Item 1", "Item 2", "Item 3"))

// Set item selection listener
searchableSpinner.setOnItemSelectedListener { selectedItem ->
    // Handle item selection
    Log.d("SearchableSpinner", "Selected: $selectedItem")
}
```

## Customization

The SearchableSpinnerView uses Material Design components and can be customized using standard Material Design attributes. You can customize:

- Hint text
- Text colors
- Background colors
- Input type
- Layout dimensions

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
