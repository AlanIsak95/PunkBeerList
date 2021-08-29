/* */
object AndroidXNavigation {

	/* */
	private object Version {

		/* */
		const val NAVIGATION = "2.3.5"

	}

	/* */
	const val FRAGMENT_KTX =
		"androidx.navigation:navigation-fragment-ktx:${Version.NAVIGATION}"

	/* */
	const val UI_KTX = "androidx.navigation:navigation-ui-ktx:${Version.NAVIGATION}"

	/* @see [https://developer.android.com/guide/navigation/navigation-pass-data] */
	const val SAFE_ARGS_GRADLE_PLUGIN =
		"androidx.navigation:navigation-safe-args-gradle-plugin:${Version.NAVIGATION}"

}