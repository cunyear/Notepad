/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demonotepad;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author Phạm Văn Hiếu
 */
public class Function_Edit {
//    Notepad notepad;
    DemoNotePad notepad;
    FindDialog find;

    public Function_Edit(FindDialog find) {
        this.find = find;
    }

    public Function_Edit(DemoNotePad notepad) {
        this.notepad = notepad;
    }
    public void undoFile(){
        
    }
    public void cutFile(){
        notepad.getTxtANotepad().cut();
    }
    public void coppyFile(){
        notepad.getTxtANotepad().copy();
    }
    public void pastFile(){
        notepad.getTxtANotepad().paste();
    }
    public void deleteFile(){
        notepad.getTxtANotepad().setText("");
    }
    
    public void selectAllFile(){
        notepad.getTxtANotepad().selectAll();
    }
    public void timeDateFile(){
        SimpleDateFormat fm= new SimpleDateFormat("hh:mm aa dd/MM/yyyy");
        Date d= new Date();
        notepad.getTxtANotepad().setText(fm.format(d));
    }
        
    public void FindNext(){
        String text= find.gettxtFind().getText();
        //
        String content= notepad.getTxtANotepad().getText();
        //
        int index=notepad.getTxtANotepad().getCaretPosition();
        int start= notepad.getTxtANotepad().getSelectionStart();
        int end= notepad.getTxtANotepad().getSelectionEnd();
        
        if(notepad.getitemFindN().isSelected()){
            if(start!=end){
                index=start+1;
            }
            
            index=content.indexOf(text,index);
            
            if(index!=-1){
                notepad.getTxtANotepad().select(index, text.length() + index);
            }else{
                JOptionPane.showMessageDialog(find, "Cannot find \""+text+"\"");
            }
        }

    }
    public void FindP(){
        String text= find.gettxtFind().getText();
        //
        String content= notepad.getTxtANotepad().getText();
        //
        int index=notepad.getTxtANotepad().getCaretPosition();
        int start= notepad.getTxtANotepad().getSelectionStart();
        int end= notepad.getTxtANotepad().getSelectionEnd();
        if(notepad.getitemFindP().isSelected()){              //find up
            if(start!=end){
                index=end-(text.length()+1);
            }
            
            index=content.lastIndexOf(text,index);
            
            if(index!=-1){
                notepad.getTxtANotepad().select(index, text.length() + index);
            }else{
                JOptionPane.showMessageDialog(find, "Cannot find \""+text+"\"");
            }
        }
    }
}
