import jm.JMC;
import jm.audio.Instrument;
import jm.music.data.Note;
import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.music.data.Score;
import jm.util.Play;
import jm.util.Write;
public class MusicUtility implements JMC {
    public static void main(String[] args){
        // Reference https://explodingart.com/jmusic/jmtutorial/t1.html
        Part p=new Part("Happy Birthday",0);
        Phrase phr=new Phrase(0.0);
        int[][] happyBirthDayPianoNotes=new int[][]{
                //Happy birthday to you
                {G4,G4,A4,G4, C5,B4},
                //Happy birthday to you
                {G4, G4, A4, G4, D5, C5},
                //Happy birthday dear someone
                {G4,G4,G5,E5,C5,B4,A4},
                //Happy birthday to you
                {F5,F5,E5,C5,D5,C5}
        };
        int lines=4;
        int notes=6;
        for(int i=0;i<lines;i++)
        {
            for(int j=0;j<notes;j++)
            {
                Play.midi(new Note(happyBirthDayPianoNotes[i][j],QN));
                phr.add(new Note(happyBirthDayPianoNotes[i][j],QN));
            }
        }
        Score score = new Score("United Coder Music Demo");
        //stochScore.addPart(inst);
        p.addPhrase(phr);
        score.addPart(p);
        // create a MIDI file of the score
        Write.midi(score, "happyBirthday.mid");
        Instrument instrument=new SawtoothInst(44100);
        Write.au(score,instrument);
    }
}
