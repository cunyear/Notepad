/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demonotepad;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author Phạm Văn Hiếu
 */
public class Function_File {
    DemoNotePad notepad;
    String fileName;
    String fileAdress;

    public Function_File(DemoNotePad notepad) {
        this.notepad = notepad;
    }
    public void newFile(){
        notepad.getTxtANotepad().setText("");
        notepad.setTitle("New");
        fileName=null;
        fileAdress=null;
    }
    public void newWindow(){
//        Object oj= setSource();
    }
    public void openFile() {
        FileDialog fd = new FileDialog(notepad, "Open", FileDialog.LOAD);
        fd.setVisible(true);

        if (fd.getFile() != null) {
            fileName = fd.getFile();
            fileAdress = fd.getDirectory();
            notepad.setTitle(fileName);
        }
        try {
            FileReader fr = new FileReader(fileAdress + fileName);
            BufferedReader br = new BufferedReader(fr);
            notepad.getTxtANotepad().setText("");
            //
            String line = null;
            while ((line = br.readLine()) != null) {
                notepad.getTxtANotepad().append(line + "\n");
            }
            br.close();
        } catch (Exception ex) {
            System.err.println(ex.toString());
        }
    }
    public void saveFile(){
        FileDialog fd= new FileDialog(notepad, "Save", FileDialog.SAVE);
        if(fileName==null){
            saveAsFile();
        }else{
            try {
                FileWriter fw=new FileWriter(fileAdress+fileName);
                fw.write(notepad.getTxtANotepad().getText());
                fw.close();
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
    }
    public void saveAsFile(){
        FileDialog fd= new FileDialog(notepad, "Save As", FileDialog.SAVE);
        fd.setVisible(true);
        if(fd.getFile()!=null){
            fileName=fd.getFile();
            fileAdress=fd.getDirectory();
            notepad.setTitle(fileName);
        }
        try {
            FileWriter fw=new FileWriter(fileAdress+fileName);
            fw.write(notepad.getTxtANotepad().getText());
            fw.close();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
    public void exit(){
        System.exit(0);
    }
}
