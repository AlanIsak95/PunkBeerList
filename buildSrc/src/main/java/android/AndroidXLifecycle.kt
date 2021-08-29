/* */
object AndroidXLifecycle {

	/* */
	private object Version {

		/* */
		const val LIFECYCLE: String = "2.3.1"
	}

	/* */
	const val LIFECYCLE_EXTENSIONS = "androidx.lifecycle:lifecycle-extensions:${Version.LIFECYCLE}"

	/* */
	const val LIFECYCLE_LIVEDATA_KTX =
		"androidx.lifecycle:lifecycle-livedata-ktx:${Version.LIFECYCLE}"

	/* */
	const val LIFECYCLE_VIEWMODEL_KTX =
		"androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.LIFECYCLE}"

	/** */
	const val LIFECYCLE_SCOPE = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.LIFECYCLE}"

}