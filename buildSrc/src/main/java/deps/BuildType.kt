package deps

interface BuildType {
    val name: String
    val isMinifyEnabled: Boolean
    val isTestCoverageEnabled: Boolean
}

object BuildTypeDebug : BuildType {
    override val name: String = "debug"
    override val isMinifyEnabled: Boolean = false
    override val isTestCoverageEnabled: Boolean = true
}

object BuildTypeRelease : BuildType {
    override val name: String = "release"
    override val isMinifyEnabled: Boolean = true
    override val isTestCoverageEnabled: Boolean = false
}
