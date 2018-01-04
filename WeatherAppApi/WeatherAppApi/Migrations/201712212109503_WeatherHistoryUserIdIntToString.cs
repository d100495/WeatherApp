namespace WeatherAppApi.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class WeatherHistoryUserIdIntToString : DbMigration
    {
        public override void Up()
        {
            AlterColumn("dbo.WeatherHistories", "UserId", c => c.String());
        }
        
        public override void Down()
        {
            AlterColumn("dbo.WeatherHistories", "UserId", c => c.Int(nullable: false));
        }
    }
}
