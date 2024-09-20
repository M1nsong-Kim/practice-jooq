/*
 * This file is generated by jOOQ.
 */
package com.practice.practice_jooq.generated.tables;


import com.practice.practice_jooq.generated.Jooq;
import com.practice.practice_jooq.generated.Keys;
import com.practice.practice_jooq.generated.tables.records.MemberRecord;

import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function4;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row4;
import org.jooq.Schema;
import org.jooq.SelectField;
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
public class Member extends TableImpl<MemberRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>jooq.member</code>
     */
    public static final Member MEMBER = new Member();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<MemberRecord> getRecordType() {
        return MemberRecord.class;
    }

    /**
     * The column <code>jooq.member.id</code>.
     */
    public final TableField<MemberRecord, String> ID = createField(DSL.name("id"), SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>jooq.member.password</code>.
     */
    public final TableField<MemberRecord, String> PASSWORD = createField(DSL.name("password"), SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>jooq.member.name</code>.
     */
    public final TableField<MemberRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>jooq.member.id_number</code>.
     */
    public final TableField<MemberRecord, String> ID_NUMBER = createField(DSL.name("id_number"), SQLDataType.VARCHAR(50).nullable(false), this, "");

    private Member(Name alias, Table<MemberRecord> aliased) {
        this(alias, aliased, null);
    }

    private Member(Name alias, Table<MemberRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>jooq.member</code> table reference
     */
    public Member(String alias) {
        this(DSL.name(alias), MEMBER);
    }

    /**
     * Create an aliased <code>jooq.member</code> table reference
     */
    public Member(Name alias) {
        this(alias, MEMBER);
    }

    /**
     * Create a <code>jooq.member</code> table reference
     */
    public Member() {
        this(DSL.name("member"), null);
    }

    public <O extends Record> Member(Table<O> child, ForeignKey<O, MemberRecord> key) {
        super(child, key, MEMBER);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Jooq.JOOQ;
    }

    @Override
    public UniqueKey<MemberRecord> getPrimaryKey() {
        return Keys.KEY_MEMBER_PRIMARY;
    }

    @Override
    public Member as(String alias) {
        return new Member(DSL.name(alias), this);
    }

    @Override
    public Member as(Name alias) {
        return new Member(alias, this);
    }

    @Override
    public Member as(Table<?> alias) {
        return new Member(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Member rename(String name) {
        return new Member(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Member rename(Name name) {
        return new Member(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Member rename(Table<?> name) {
        return new Member(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<String, String, String, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function4<? super String, ? super String, ? super String, ? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function4<? super String, ? super String, ? super String, ? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
