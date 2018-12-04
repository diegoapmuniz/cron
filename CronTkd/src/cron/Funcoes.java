/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cron;

import dao.ParameterDao;
import entidades.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;

/**
 *
 * @author p062964
 */
public class Funcoes {
    String minutos;
    Parameter parametros = new Parameter();
    List<Parameter> listaParametros = new ArrayList<>();
    
    public List<Parameter> carregaParametros(){
        ParameterDao cronDAO = ParameterDao.getInstance();
        List<Parameter> lParameters = cronDAO.recoverAllParameters();
         
        return lParameters;
        
    }
    public void salvaParametros(List<Parameter> parametros){
    ParameterDao cronDAO = ParameterDao.getInstance();
    cronDAO.openConnection();
    
        try {
            cronDAO.saveParameters(parametros);
        } catch (Exception ex) {
            Logger.getLogger(Funcoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void mudaBackground(JDialog frame){
        frame.getContentPane().setBackground(new java.awt.Color(218,230,205));
    }
    
    public void fechaBanco(){
    ParameterDao cronDAO = ParameterDao.getInstance();
    cronDAO.closeHsqldb();
     }
    
    
    
}
