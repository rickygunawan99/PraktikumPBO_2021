package controller;

import Entity.PembeliEntity;
import Model.PembeliModel;

import java.util.ArrayList;

public class PembeliController extends ObjectModelController{

    //String nama, String nama_akun, String id_akun, String notelp
    public int insert(PembeliEntity pembeli){
        return pembeliModel.insertPembeli(new PembeliEntity(pembeli.getNama(), pembeli.getId_game(),
                pembeli.getNama_akun(), pembeli.getNotelp()));
    }

    public ArrayList<PembeliEntity> getPembeli(){
        return pembeliModel.getPembeli();
    }

    public PembeliEntity getPembeli(int id){
        return pembeliModel.getPembeli(id);
    }
}
