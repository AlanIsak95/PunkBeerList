object Room {

	/* */
	private object Version {
		/** */
		const val ROOM = "2.3.0"
	}

	/** */
	const val RUNTIME = "androidx.room:room-runtime:${Version.ROOM}"
	/** */
	const val KAPT_COMPILER = "androidx.room:room-compiler:${Version.ROOM}"
	/** */
	const val KTX = "androidx.room:room-ktx:${Version.ROOM}"
	/** */
	const val COROUTINES = "androidx.room:room-ktx:${Version.ROOM}"

}