import net.kyori.indra.git.IndraGitExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.the

fun Project.branchName(): String =
    the<IndraGitExtension>().branchName() ?: System.getenv("BRANCH_NAME") ?: "local/dev"

fun Project.shouldAddBranchName(): Boolean =
    System.getenv("IGNORE_BRANCH")?.toBoolean() ?: (branchName() !in arrayOf("master", "local/dev"))

fun Project.versionWithBranchName(): String =
    branchName().replace(Regex("[^0-9A-Za-z-_]"), "-") + '-' + version
