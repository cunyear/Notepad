/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demonotepad;

import java.awt.Font;

/**
 *
 * @author Phạm Văn Hiếu
 */
public class Function_View {
    DemoNotePad notepad;

    public Function_View(DemoNotePad notepad) {
        this.notepad = notepad;
    }
    public void zoomInFile(){
        Font f= notepad.getTxtANotepad().getFont();
        notepad.getTxtANotepad().setFont(new Font(f.getFontName(),f.getSize(),f.getSize()+5));
    }
    public void zoomOutFile(){
        Font f= notepad.getTxtANotepad().getFont();
        notepad.getTxtANotepad().setFont(new Font(f.getFontName(),f.getSize(),f.getSize()-5));
    }
}
