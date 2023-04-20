/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.medic.dao.rendezVous;

import com.medic.entities.RendezVous;
import java.util.List;

/**
 *
 * @author hundl
 */
public interface RendezVousDao {
    List<RendezVous> findAll();
    RendezVous findByIdRv(int id);
    List<RendezVous> findByIdPatient(int idPatient);
    List<RendezVous> findByIdMedecin(int idMedecin);
    RendezVous verifierRendezVousPris(int idMedecin,String date,String heure);
    int findMaxIdRv();
    boolean create(RendezVous rendezVous);
    boolean update(RendezVous rendezVous);
    boolean delete(int idRv);
 
}
