    Path path = hgCmdLineInterface.extractRawManifest();
        Files.readAllLines(path, Charset.forName(System.getProperty("file.encoding", "UTF-8")));
    Path path = hgCmdLineInterface.extractRawManifest(ImmutableList.of("change2", "file1"));
        Files.readAllLines(path, Charset.forName(System.getProperty("file.encoding", "UTF-8")));
    Path path = hgCmdLineInterface.extractRawManifest();
        Files.readAllLines(path, Charset.forName(System.getProperty("file.encoding", "UTF-8")));
            "file1\u00000000000000000000000000000000000000000000r");