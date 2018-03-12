namespace WeatherAppApi.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class FavoriteToWatherStation : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.ApplicationUserFavorites", "ApplicationUser_Id", "dbo.AspNetUsers");
            DropForeignKey("dbo.ApplicationUserFavorites", "Favorite_FavoriteId", "dbo.Favorites");
            DropIndex("dbo.ApplicationUserFavorites", new[] { "ApplicationUser_Id" });
            DropIndex("dbo.ApplicationUserFavorites", new[] { "Favorite_FavoriteId" });
            CreateTable(
                "dbo.WeatherStations",
                c => new
                    {
                        WeatherStationId = c.Int(nullable: false, identity: true),
                        CityName = c.String(),
                        Longitude = c.Double(nullable: false),
                        Latitude = c.Double(nullable: false),
                    })
                .PrimaryKey(t => t.WeatherStationId);
            
            CreateTable(
                "dbo.FavoriteWeatherStations",
                c => new
                    {
                        Id = c.String(nullable: false, maxLength: 128),
                        WeatherStationId = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.Id, t.WeatherStationId })
                .ForeignKey("dbo.AspNetUsers", t => t.Id, cascadeDelete: true)
                .ForeignKey("dbo.WeatherStations", t => t.WeatherStationId, cascadeDelete: true)
                .Index(t => t.Id)
                .Index(t => t.WeatherStationId);
            
            DropTable("dbo.Favorites");
            DropTable("dbo.ApplicationUserFavorites");
        }
        
        public override void Down()
        {
            CreateTable(
                "dbo.ApplicationUserFavorites",
                c => new
                    {
                        ApplicationUser_Id = c.String(nullable: false, maxLength: 128),
                        Favorite_FavoriteId = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.ApplicationUser_Id, t.Favorite_FavoriteId });
            
            CreateTable(
                "dbo.Favorites",
                c => new
                    {
                        FavoriteId = c.Int(nullable: false, identity: true),
                        CityName = c.String(),
                        Longitude = c.Double(nullable: false),
                        Latitude = c.Double(nullable: false),
                    })
                .PrimaryKey(t => t.FavoriteId);
            
            DropForeignKey("dbo.FavoriteWeatherStations", "WeatherStationId", "dbo.WeatherStations");
            DropForeignKey("dbo.FavoriteWeatherStations", "Id", "dbo.AspNetUsers");
            DropIndex("dbo.FavoriteWeatherStations", new[] { "WeatherStationId" });
            DropIndex("dbo.FavoriteWeatherStations", new[] { "Id" });
            DropTable("dbo.FavoriteWeatherStations");
            DropTable("dbo.WeatherStations");
            CreateIndex("dbo.ApplicationUserFavorites", "Favorite_FavoriteId");
            CreateIndex("dbo.ApplicationUserFavorites", "ApplicationUser_Id");
            AddForeignKey("dbo.ApplicationUserFavorites", "Favorite_FavoriteId", "dbo.Favorites", "FavoriteId", cascadeDelete: true);
            AddForeignKey("dbo.ApplicationUserFavorites", "ApplicationUser_Id", "dbo.AspNetUsers", "Id", cascadeDelete: true);
        }
    }
}
