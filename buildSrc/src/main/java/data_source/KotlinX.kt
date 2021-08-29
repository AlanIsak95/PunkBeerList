/* */
object KotlinX {

	/* */
	private object Version {

		/* */
		const val KOTLINX = "1.2.1"

		/* */
		const val KOTLINX_CONVERTER = "0.8.0"

	}

	/* */
	const val KOTLINX = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Version.KOTLINX}"

	/* */
	const val KOTLINX_CONVERTER =
		"com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Version.KOTLINX_CONVERTER}"

}