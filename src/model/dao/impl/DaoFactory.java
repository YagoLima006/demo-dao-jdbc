package model.dao.impl;

import db.DB;
import model.dao.DepartmentDao;
import model.dao.SellerDao;

public class DaoFactory 
{
	
	public static SellerDao createSellerDao()
	{
		return new SellerDaoJDBC(DB.getConnetion());
	}
	
	public static DepartmentDao createDepartmentDao()
	{
		return new DepartmentDaoJDBC(DB.getConnetion());
	}
}
