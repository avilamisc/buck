import static org.junit.Assume.assumeTrue;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
  @Rule public ExpectedException exception = ExpectedException.none();
  /**
   * *
   * <p>Test data:
   *
   * <p>The following repo is used in the tests:
   * There are two different variants (both stored inside HG_REPOS_ZIP):
   * <p>hg_repo_two: above, current tip @branch_from_master2, and no local changes. hg_repo_three:
   * above, current tip @branch_from_master3, and with local changes.
   * <p>Additionally hg_repo_with_subdir is a new hg_repo with a directory called subdir
  public void setUp() throws InterruptedException {
    assumeTrue(repoTwoCmdLine.isSupportedVersionControlSystem());
        ImmutableSet.of("A tracked_change", "? local_change"), repoThreeCmdLine.changedFiles("."));
        ImmutableSet.of("A tracked_change", "? local_change"), repoThreeCmdLine.changedFiles("."));
            "A tracked_change", "A change3", "A change3-2", "? local_change"));
    ImmutableList<String> expectedValue =
        ImmutableList.of(
            "# HG changeset patch",
            "# User Joe Blogs <joe.blogs@fb.com>",
            "# Date 1440589545 -3600",
            "#      Wed Aug 26 12:45:45 2015 +0100",
            "# Node ID 2911b3cab6b24374a3649ebb96b0e53324e9c02e",
            "# Parent  b1fd7e5896af8aa30e3e797ef1445605eec6d055",
            "diverge from master_2",
            "",
            "diff --git a/change2 b/change2",
            "new file mode 100644",
            "");
      throws VersionControlCommandFailedException, InterruptedException, IOException {
    HgCmdLineInterface hgCmdLineInterface = makeHgCmdLine(reposPath.resolve(REPO_TWO_DIR));
    List<String> lines =
        Files.readAllLines(
            Paths.get(path), Charset.forName(System.getProperty("file.encoding", "UTF-8")));
    List<String> expected =
        ImmutableList.of(
            "change2\0b80de5d138758541c5f05265ad144ab9fa86d1db",
            "file1\0b80de5d138758541c5f05265ad144ab9fa86d1db",
            "file2\0b80de5d138758541c5f05265ad144ab9fa86d1db");
    HgCmdLineInterface hgCmdLineInterface = makeHgCmdLine(localReposPath.resolve(REPO_TWO_DIR));
    List<String> lines =
        Files.readAllLines(
            Paths.get(path), Charset.forName(System.getProperty("file.encoding", "UTF-8")));
    List<String> expected =
        ImmutableList.of(
            "change2\u0000b80de5d138758541c5f05265ad144ab9fa86d1db",
            "file1\u0000b80de5d138758541c5f05265ad144ab9fa86d1db",
            "file2\u0000b80de5d138758541c5f05265ad144ab9fa86d1db",
            "file1\u00000000000000000000000000000000000000000000d");
      throws VersionControlCommandFailedException, InterruptedException, IOException {
    HgCmdLineInterface hgCmdLineInterface =
        makeHgCmdLine(reposPath.resolve(REPO_WITH_SUB_DIR + "/subdir"));
    HgCmdLineInterface hgCmdLineInterface =
        new HgCmdLineInterface(
            new TestProcessExecutorFactory(),
            reposPath,
            new VersionControlBuckConfig(FakeBuckConfig.builder().build()).getHgCmd(),
            ImmutableMap.of());
  private static Path explodeReposZip() throws InterruptedException, IOException {
  private static Path explodeReposZip(Path destination) throws InterruptedException, IOException {
        hgRepoZipCopyPath, reposPath, Unzip.ExistingFileMode.OVERWRITE_AND_CLEAN_DIRECTORIES);

  private static HgCmdLineInterface makeHgCmdLine(Path repoRootDir) {
    return new HgCmdLineInterface(
        new TestProcessExecutorFactory(),
        repoRootDir,
        new VersionControlBuckConfig(FakeBuckConfig.builder().build()).getHgCmd(),
        ImmutableMap.of());
  }