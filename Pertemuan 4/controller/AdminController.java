package controller;

import Entity.AdminEntity;
import Entity.PembeliEntity;
import Entity.ProdukEntity;

public class AdminController extends ObjectModelController{

    public int login(String id, String password){
        return adminModel.cekData(id,password);
    }

    public AdminEntity getAdmin(int id){
        return adminModel.getAdmin(id);
    }

    public int updateProfil(int id, AdminEntity admin){
        return adminModel.updateProfil(id,admin);
    }

    public int updateStatusTransaksi(int id){
        return adminModel.updateStatusTransaksi(id);
    }

    public int deleteTransaksi(int idx){
        return adminModel.deleteTransaksi(idx);
    }

    public int insertAdmin(AdminEntity admin){
        return adminModel.insertData(admin);
    }
}
