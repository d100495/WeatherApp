namespace WeatherAppApi.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Favorities : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Favorites",
                c => new
                    {
                        FavoriteId = c.Int(nullable: false, identity: true),
                        CityName = c.String(),
                    })
                .PrimaryKey(t => t.FavoriteId);
            
            CreateTable(
                "dbo.ApplicationUserFavorites",
                c => new
                    {
                        ApplicationUser_Id = c.String(nullable: false, maxLength: 128),
                        Favorite_FavoriteId = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.ApplicationUser_Id, t.Favorite_FavoriteId })
                .ForeignKey("dbo.AspNetUsers", t => t.ApplicationUser_Id, cascadeDelete: true)
                .ForeignKey("dbo.Favorites", t => t.Favorite_FavoriteId, cascadeDelete: true)
                .Index(t => t.ApplicationUser_Id)
                .Index(t => t.Favorite_FavoriteId);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.ApplicationUserFavorites", "Favorite_FavoriteId", "dbo.Favorites");
            DropForeignKey("dbo.ApplicationUserFavorites", "ApplicationUser_Id", "dbo.AspNetUsers");
            DropIndex("dbo.ApplicationUserFavorites", new[] { "Favorite_FavoriteId" });
            DropIndex("dbo.ApplicationUserFavorites", new[] { "ApplicationUser_Id" });
            DropTable("dbo.ApplicationUserFavorites");
            DropTable("dbo.Favorites");
        }
    }
}
