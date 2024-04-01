package com.ttknpdev.client.postgres;


public class Command {
    public static final String MOBILES_READS = "select * from  mobiles;";
    public static final String MOBILES_READ = "select * from  mobiles where mid = ?;";
    public static final String MOBILES_CREATE = "insert into mobiles (brand,model,stock,price,states) values( ? , ? , ? , ? , ?);";
    public static final String MOBILES_UPDATE = "update mobiles set brand = ? , model = ? , stock = ? , price = ? , states = ? where mid = ?;";
    public static final String MOBILES_DELETE = "delete from mobiles where mid = ?;";
}
