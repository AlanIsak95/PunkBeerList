/* */
object AndroidXTesting {

	/* */
	private object Version {

		/* */
		const val JUNIT = "1.1.3"

		/* */
		const val ESPRESSO_CORE = "3.4.0"


	}

	/* */
	const val JUNIT = "androidx.test.ext:junit:${Version.JUNIT}"

	/* */
	const val RUNNER = "androidx.test.runner.AndroidJUnitRunner"

	/* @see [https://developer.android.com/training/testing/espresso] */
	const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Version.ESPRESSO_CORE}"

}