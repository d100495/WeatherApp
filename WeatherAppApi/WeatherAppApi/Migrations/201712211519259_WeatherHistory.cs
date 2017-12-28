namespace WeatherAppApi.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class WeatherHistory : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.WeatherHistories",
                c => new
                    {
                        WeatherId = c.Int(nullable: false, identity: true),
                        Longitude = c.Double(nullable: false),
                        Latitude = c.Double(nullable: false),
                        Temperature = c.Double(nullable: false),
                        Pressure = c.Double(nullable: false),
                        WindSpeed = c.Double(nullable: false),
                        WindChill = c.Double(nullable: false),
                        Date = c.DateTime(nullable: false),
                        UserId = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.WeatherId);
            
        }
        
        public override void Down()
        {
            DropTable("dbo.WeatherHistories");
        }
    }
}
