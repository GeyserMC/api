import net.kyori.indra.git.IndraGitExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.the

fun Project.branchName(): String =
  the<IndraGitExtension>().branchName().getOrElse(System.getenv("BRANCH_NAME") ?: "local/dev")

fun Project.shouldAddBranchName(versionString: Any): Boolean {
  val version = versionString.toString().removeSuffix("-SNAPSHOT")
  return branchName() !in arrayOf("master", "main", "local/dev", "api/$version")
}

fun Project.versionWithBranchName(): String =
  branchName().replace(Regex("[^0-9A-Za-z-_]"), "-") + '-' + version
