import net.kyori.indra.git.IndraGitExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.the

fun Project.isSnapshot(): Boolean =
    version.toString().endsWith("-SNAPSHOT")

fun Project.branchName(): String =
    the<IndraGitExtension>().branchName() ?: System.getenv("GIT_BRANCH") ?: "local/dev"

fun Project.shouldAddBranchName(): Boolean =
    System.getenv("IGNORE_BRANCH")?.toBoolean() ?: (branchName() !in arrayOf("master", "local/dev"))

fun Project.versionWithBranchName(): String =
    branchName().replace(Regex("[^0-9A-Za-z-_]"), "-") + '-' + version
