/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRSClasses.Commands;

import java.io.*;
import java.sql.Connection;

/**
 *
 * @author Administrator
 */
public interface Command extends Serializable{
    public void execute(ObjectInputStream ois,ObjectOutputStream oos,Connection c);
}
