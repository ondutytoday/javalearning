package ioclasses;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.zip.GZIPOutputStream;

public class YetAnotherArchiveWriter implements AutoCloseable {
	
	private final DataOutputStream outputStream;
	
	public YetAnotherArchiveWriter (Path outputFile) throws IOException {
		// TODO Auto-generated constructor stub
		this.outputStream = new DataOutputStream(new GZIPOutputStream(Files.newOutputStream(
				outputFile,
				StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)));
	}
	
	public void addDirectoryRecursively (Path directory) throws IOException {
		Files.walkFileTree(directory, new SimpleFileVisitor<Path> () {
			@Override
			public FileVisitResult visitFile (Path file, BasicFileAttributes attrs) throws IOException {
				addFile(file, directory, attrs);
				return FileVisitResult.CONTINUE;
			}
		});
	}
	
	private void addFile (Path file, Path baseDirectory, BasicFileAttributes fileAttributes) throws IOException  {
		outputStream.writeUTF(baseDirectory.relativize(file).toString());
		outputStream.writeLong(fileAttributes.creationTime().toMillis());
		outputStream.writeLong(fileAttributes.lastModifiedTime().toMillis());
		try (OutputStream fileContentStream = new EmbeddedOutputStream (outputStream)) {
			Files.copy(file, fileContentStream);
		}
		
	}
	
	
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		outputStream.close();
	}
}
