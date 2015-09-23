# RadioBar
[![JitPack](https://img.shields.io/github/release/acontenti/RadioBar.svg?label=JitPack)](https://jitpack.io/#acontenti/RadioBar/1.0)

A re-implementation of Android RadioGroup with images instead of RadioButtons.

It consists of two Views:
- RadioBar
- RadioImageView

##Getting Started
### Adding to Android Studio project
1. Add these lines to `build.gradle` of your project
```groovy
repositories {
	// ...
	maven { url "https://jitpack.io" }
}
```

2. Add these lines to `build.gradle` of your module
```groovy
dependencies {
	// ...
	compile 'com.github.acontenti:RadioBar:1.1'
}
```
###Example code
XML layout example
```xml
<it.psas.radiobar.RadioBar
	android:id="@+id/radioBarId"
	android:layout_width="wrap_content"
	android:layout_height="match_parent"
	app:orientation="horizontal">

	<it.psas.radiobar.RadioImageView
		android:id="@+id/radioBar1_element1"
		android:layout_width="48dp"
		android:layout_height="48dp"
		app:srcOn="@drawable/ic_action_example_1"
		app:srcOff="@drawable/ic_action_example_1_off"/>

	<it.psas.radiobar.RadioImageView
		android:id="@+id/radioBar1_element2"
		android:layout_width="48dp"
		android:layout_height="48dp"
		app:srcOn="@drawable/ic_action_example_2"
		app:srcOff="@drawable/ic_action_example_1_off"/>

</it.psas.radiobar.RadioBar>
```
Java implementation
```java
RadioBar mRadioBar = (RadioBar) findViewById(R.id.radioBar1);
mRadioBar.setOnSelectedItemChangeListener(new RadioBar.OnSelectedItemChangeListener() {
	@Override
	public void onSelectedItemChange(RadioBar radioBar, int id, int position) {
		mSelectedRadioImageViewOldPosition = mSelectedRadioImageViewPosition;
		mSelectedRadioImageViewPosition = position;
		RadioImageView mSelectedRadioImageView = (RadioImageView) findViewById(id);
		
	}
});
int mSelectedRadioImageViewId = mRadioBar.getSelectedRadioImageViewId();
RadioImageView mSelectedRadioImageView = (RadioImageView) findViewById(mSelectedRadioImageViewId);
```
##Copyright
Copyright &copy; 2015, Alessandro Contenti.

This work is licensed under a [Creative Commons Attribution-ShareAlike 4.0 International License](http://creativecommons.org/licenses/by-sa/4.0/).
