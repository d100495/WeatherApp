namespace WeatherAppApi.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class UsersWeatherHistory : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.AspNetUsers", "Discriminator", c => c.String(nullable: false, maxLength: 128));
            AddColumn("dbo.WeatherHistories", "Id", c => c.String(maxLength: 128));
            CreateIndex("dbo.WeatherHistories", "Id");
            AddForeignKey("dbo.WeatherHistories", "Id", "dbo.AspNetUsers", "Id");
            DropColumn("dbo.WeatherHistories", "UserId");
        }
        
        public override void Down()
        {
            AddColumn("dbo.WeatherHistories", "UserId", c => c.String());
            DropForeignKey("dbo.WeatherHistories", "Id", "dbo.AspNetUsers");
            DropIndex("dbo.WeatherHistories", new[] { "Id" });
            DropColumn("dbo.WeatherHistories", "Id");
            DropColumn("dbo.AspNetUsers", "Discriminator");
        }
    }
}
