/* */
object AndroidX {

	/* */
	private object Version {

		/* */
		const val CORE = "1.6.0"

		/* */
		const val APP_COMPAT = "1.3.1"

		/* */
		const val CONSTRAINT_LAYOUT = "2.0.4"

		/* */
		const val BROWSER = "1.3.0"

		/* */
		const val EMOJI = "1.1.0"

		/* */
		const val RECYCLER_VIEW = "1.2.1"

	}

	/* */
	const val CORE = "androidx.core:core-ktx:${Version.CORE}"

	/* */
	const val APP_COMPAT = "androidx.appcompat:appcompat:${Version.APP_COMPAT}"

	/* @see [https://developer.android.com/reference/androidx/constraintlayout/widget/ConstraintLayout] */
	const val CONSTRAINT_LAYOUT =
		"androidx.constraintlayout:constraintlayout:${Version.CONSTRAINT_LAYOUT}"

	/* @see [https://developer.chrome.com/docs/android/custom-tabs/overview/] */
	const val BROWSER = "androidx.browser:browser:${Version.BROWSER}"

	/* @see [https://developer.android.com/guide/topics/ui/look-and-feel/emoji-compat] */
	const val EMOJI = "androidx.emoji:emoji:${Version.EMOJI}"

	/* */
	const val EMOJI_APPCOMPAT = "androidx.emoji:emoji-appcompat:${Version.EMOJI}"

	/* */
	const val EMOJI_BUNDLED = "androidx.emoji:emoji-bundled:${Version.EMOJI}"

	/* @see [https://developer.android.com/reference/androidx/recyclerview/widget/RecyclerView.Recycler] */
	const val RECYCLER_VIEW = "androidx.recyclerview:recyclerview:${Version.RECYCLER_VIEW}"


}