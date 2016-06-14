package chap16;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.*;
import java.util.*;

/**
 * Created by anray on 10.06.2016.
 */
public class Sort {
    BufferedReader br;
    File file;
    ArrayList<Song> songs = new ArrayList<Song>();
    HashSet<Song> songHashSet = new HashSet<Song>();
    TreeSet<Song> songTreeSet = new TreeSet<Song>(new ArtistCompare());
    ArrayList<Bit> bitList = new ArrayList<Bit>();
    ArrayList<MyIntf> intfList = new ArrayList<MyIntf>();


    public static void main(String[] args){
     Sort ss = new Sort();
        ss.go();

    }

    public void go(){
        readMethod();
        Collections.sort(songs, new YearCompare());
        System.out.print("YearCompare:");
        System.out.println(songs);

        Collections.sort(songs);
        System.out.print("TitleCompare:");
        System.out.println(songs);

        songHashSet.addAll(songs);
        System.out.println(songHashSet);

        songTreeSet.addAll(songHashSet);
        System.out.println(songTreeSet);

        bitList.add(new Bit("Hello", "Bye", 9));
        bitList.get(0).duration = 5;
        //songs = bitList;
        System.out.println(songs);
        ArrayList<MyIntf> intfl = new ArrayList<MyIntf>();
        //fdgdfgfd
        //dfgdfgdf
        ArrayList<MyIntf> intfl2 = new ArrayList<MyIntf>();
        ArrayList<MyIntf> intfl3 = new ArrayList<MyIntf>();
//sdfsd



        List<Song> lls = songs;

        listsProcess(bitList);
        listsProcess(songs);
        listsProcess(lls);

        listsProcess2(bitList);
        listsProcess2(songs);
        listsProcess2(lls);

        MyIntf a = new Song("Roxette","How do you do?", 6);
        System.out.println(a);
        System.out.println(((Song) a).getTitle());

        intfl.add(songs.get(0));
        System.out.println(((Song) intfl.get(0)).getTitle());

    }

    public void readMethod(){
        String line;

        try {

            file = new File("Song.txt");
            FileReader fis = new FileReader(file);
            br = new BufferedReader(fis);

            while ((line = br.readLine()) != null) {
                addToArraylist(line);
            }
        } catch (Exception ex){   }

    }
    public void addToArraylist(String lineToParse){
        String[] line2 = lineToParse.split("/");

        songs.add(new Song(line2[0],line2[1],Integer.parseInt(line2[2])));
    }


    class TitleCompare implements Comparator<Song> {
        public int compare(Song one, Song two){
            return one.getTitle().compareTo(two.getTitle());
        }
    }
    class ArtistCompare implements Comparator<Song>{
        public int compare(Song one,Song two){
            return one.getArtist().compareTo(two.getArtist());
        }
    }

    class YearCompare implements Comparator<Song>{
        public int compare(Song one,Song two){
            return (one.getYear() - two.getYear());
        }
    }

    public <T extends MyIntf> void listsProcess (List<T> list){
        System.out.println(list.get(0));

    }

    public void listsProcess2(List<? extends Song> list){
        System.out.println(list.get(0));

    }

}

