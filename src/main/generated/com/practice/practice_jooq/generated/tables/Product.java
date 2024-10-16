/*
 * This file is generated by jOOQ.
 */
package com.practice.practice_jooq.generated.tables;


import com.practice.practice_jooq.generated.Jooq;
import com.practice.practice_jooq.generated.Keys;
import com.practice.practice_jooq.generated.enums.ProductCategory;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Product extends TableImpl<Record> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>jooq.product</code>
     */
    public static final Product PRODUCT = new Product();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Record> getRecordType() {
        return Record.class;
    }

    /**
     * The column <code>jooq.product.price</code>.
     */
    public final TableField<Record, Integer> PRICE = createField(DSL.name("price"), SQLDataType.INTEGER.defaultValue(DSL.field(DSL.raw("NULL"), SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>jooq.product.id</code>.
     */
    public final TableField<Record, String> ID = createField(DSL.name("id"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>jooq.product.name</code>.
     */
    public final TableField<Record, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(255).defaultValue(DSL.field(DSL.raw("NULL"), SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>jooq.product.category</code>.
     */
    public final TableField<Record, ProductCategory> CATEGORY = createField(DSL.name("category"), SQLDataType.VARCHAR(7).defaultValue(DSL.field(DSL.raw("NULL"), SQLDataType.VARCHAR)).asEnumDataType(com.practice.practice_jooq.generated.enums.ProductCategory.class), this, "");

    /**
     * The column <code>jooq.product.created_at</code>.
     */
    public final TableField<Record, LocalDateTime> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(0).defaultValue(DSL.field(DSL.raw("NULL"), SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>jooq.product.updated_at</code>.
     */
    public final TableField<Record, LocalDateTime> UPDATED_AT = createField(DSL.name("updated_at"), SQLDataType.LOCALDATETIME(0).defaultValue(DSL.field(DSL.raw("NULL"), SQLDataType.LOCALDATETIME)), this, "");

    private Product(Name alias, Table<Record> aliased) {
        this(alias, aliased, null);
    }

    private Product(Name alias, Table<Record> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>jooq.product</code> table reference
     */
    public Product(String alias) {
        this(DSL.name(alias), PRODUCT);
    }

    /**
     * Create an aliased <code>jooq.product</code> table reference
     */
    public Product(Name alias) {
        this(alias, PRODUCT);
    }

    /**
     * Create a <code>jooq.product</code> table reference
     */
    public Product() {
        this(DSL.name("product"), null);
    }

    public <O extends Record> Product(Table<O> child, ForeignKey<O, Record> key) {
        super(child, key, PRODUCT);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Jooq.JOOQ;
    }

    @Override
    public UniqueKey<Record> getPrimaryKey() {
        return Keys.KEY_PRODUCT_PRIMARY;
    }

    @Override
    public Product as(String alias) {
        return new Product(DSL.name(alias), this);
    }

    @Override
    public Product as(Name alias) {
        return new Product(alias, this);
    }

    @Override
    public Product as(Table<?> alias) {
        return new Product(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Product rename(String name) {
        return new Product(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Product rename(Name name) {
        return new Product(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Product rename(Table<?> name) {
        return new Product(name.getQualifiedName(), null);
    }
}
