package java_intermediate_training;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.*;

public class MainFiloIO {

	public static void usingPathClass() throws IOException {

		Path path = Paths.get("/temp/src/loremipsum.txt");
		Path path2 = Paths.get("loremipsum.txt");
		System.out.println(path.toString());
		System.out.println(path.getFileName());
		System.out.println(path.getNameCount());
		System.out.println(path.getName(0));
		System.out.println(path.getName(2));
		System.out.println(path.getName(path.getNameCount()-1));

		Path realPath = path2.toRealPath(LinkOption.NOFOLLOW_LINKS);
		System.out.println(realPath);	
	}

	public static void usingFilesClass() throws IOException {
		Path source = Paths.get("loremipsum.txt");
		System.out.println(source.getFileName());
		Path target = Paths.get("newfiles.txt");
		Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);

		//		Path toDetele = Paths.get("newfiles.txt");
		//		Files.delete(toDetele);
		//		System.out.println("File deleted");		
		Path newdir = Paths.get("lib/newdir");
		Files.createDirectory(newdir);

		Files.move(source, newdir.resolve(source.getFileName()), 
				StandardCopyOption.REPLACE_EXISTING);		
	}

	public static void readingAndWriting() throws IOException {
		Path source = Paths.get("loremipsum.txt");
		System.out.println(source.getFileName());
		Path target = Paths.get("newfiles.txt");
		Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);

		Charset charset = Charset.forName("US-ASCII");
		ArrayList<String> lines = new ArrayList<>();

		try (BufferedReader reader = Files.newBufferedReader(source, charset)) 
		{
			String line = null;
			while((line = reader.readLine())!= null){
				System.out.println(line);
				lines.add(line);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		try (BufferedWriter writer = Files.newBufferedWriter(target, charset))
		{
			Iterator<String> iterator = lines.iterator();
			while(iterator.hasNext()){
				String s = iterator.next();
				writer.append(s, 0, s.length());
				writer.newLine();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());;
		}

	}

	public static void fileTree() throws IOException{
		Path fileDir = Paths.get("files");
		MyFileVisitor visitor = new MyFileVisitor();
		Files.walkFileTree(fileDir, visitor);
	}

	public static void findingFiles() throws IOException{
		Path fileDir = Paths.get("files");

		FileFinder finder =new FileFinder("file1.txt");
		Files.walkFileTree(fileDir, finder);

		ArrayList<Path> foundfiles =finder.foundPaths;

		if (foundfiles.size() > 0){
			for (Path path : foundfiles) {
				System.out.println(path.toRealPath(LinkOption.NOFOLLOW_LINKS));
			}
		}
		else{
			System.out.println("No files were found");
		}
	}

	public static void watchingDirectory(){
		try (WatchService service = FileSystems.getDefault().newWatchService()) {
			Map<WatchKey, Path> keyMap = new HashMap<>();
			Path path = Paths.get("files");
			keyMap.put(path.register(service, 
					StandardWatchEventKinds.ENTRY_CREATE,
					StandardWatchEventKinds.ENTRY_DELETE,
					StandardWatchEventKinds.ENTRY_MODIFY),
					path);

			WatchKey watchKey;

			do {
				watchKey = service.take();
				Path eventDir = keyMap.get(watchKey);

				for (WatchEvent<?> event : watchKey.pollEvents()) {
					WatchEvent.Kind<?> kind = event.kind();
					Path eventPath = (Path)event.context();
					System.out.println(eventDir + ": " + kind + ": " + eventPath);
				}

			} while (watchKey.reset());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void readingBinary(){
		try (
				FileInputStream in = new FileInputStream("flower.jpg");
				FileOutputStream out = new FileOutputStream("newflower.jpg");
				//FileReader fReadr = new FileReader("aa.txt");
				//FileWriter fWriter = new FileWriter("bb.txt");
				) {
			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	public static void scanningTokenizer() {
		try (
				Scanner s = new Scanner(new BufferedReader(new FileReader("tokenizedtext.txt")));
				) {
			s.useDelimiter(",");
			while (s.hasNext()) {
				System.out.println(s.next());
			}
			System.out.println("All done!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 

	}

public static void main(String[] args) throws IOException {
	System.out.println("---------------usingPathClass-------------");
	usingPathClass();
	System.out.println("---------------usingFilesClass-------------");
	//usingFilesClass();
	System.out.println("---------------readingAndWriting-------------");
	readingAndWriting();
	System.out.println("---------------fileTree-------------");
	fileTree();
	System.out.println("---------------findingFiles-------------");
	findingFiles();
	System.out.println("---------------watchingDirectory-------------");
	//watchingDirectory();
	System.out.println("---------------readingBinary-------------");
	readingBinary();
	System.out.println("---------------scanningTokenizer-------------");
	scanningTokenizer();
}
}
