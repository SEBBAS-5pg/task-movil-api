import { Module } from '@nestjs/common';
import { ProductModule } from './product/product.module';
import { CategoryModule } from './category/category.module';
@Module({
  imports: [CategoryModule, ProductModule],
  controllers: [],
  providers: [],
})
export class AppModule {}
