namespace WeatherAppApi.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AddLatLonToFavoriteTable : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Favorites", "Longitude", c => c.Double(nullable: false));
            AddColumn("dbo.Favorites", "Latitude", c => c.Double(nullable: false));
        }
        
        public override void Down()
        {
            DropColumn("dbo.Favorites", "Latitude");
            DropColumn("dbo.Favorites", "Longitude");
        }
    }
}
