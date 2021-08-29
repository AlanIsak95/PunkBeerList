/* */
object Retrofit {

	/* */
	private object Version {

		/* */
		const val RETROFIT = "2.9.0"

		/* */
		const val LOGGING_INTERCEPTOR = "4.8.0"

		/* */
		const val MOSHI = "2.4.0"

	}

	/* */
	const val RETROFIT = "com.squareup.retrofit2:retrofit:${Version.RETROFIT}"

	/* */
	const val LOGGING_INTERCEPTOR =
		"com.squareup.okhttp3:logging-interceptor:${Version.LOGGING_INTERCEPTOR}"

	const val GSON = "com.squareup.retrofit2:converter-gson:${Version.RETROFIT}"

	const val MOSHI = "com.squareup.retrofit2:converter-moshi:${Version.MOSHI}"

}