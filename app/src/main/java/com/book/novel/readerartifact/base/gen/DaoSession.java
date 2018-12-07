package com.book.novel.readerartifact.base.gen;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.book.novel.readerartifact.ui.bookshelf.entity.BookChapterBean;
import com.book.novel.readerartifact.ui.bookshelf.entity.CollectBookBean;
import com.book.novel.readerartifact.ui.readbook.BookRecordBean;

import com.book.novel.readerartifact.base.gen.BookChapterBeanDao;
import com.book.novel.readerartifact.base.gen.CollectBookBeanDao;
import com.book.novel.readerartifact.base.gen.BookRecordBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig bookChapterBeanDaoConfig;
    private final DaoConfig collectBookBeanDaoConfig;
    private final DaoConfig bookRecordBeanDaoConfig;

    private final BookChapterBeanDao bookChapterBeanDao;
    private final CollectBookBeanDao collectBookBeanDao;
    private final BookRecordBeanDao bookRecordBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        bookChapterBeanDaoConfig = daoConfigMap.get(BookChapterBeanDao.class).clone();
        bookChapterBeanDaoConfig.initIdentityScope(type);

        collectBookBeanDaoConfig = daoConfigMap.get(CollectBookBeanDao.class).clone();
        collectBookBeanDaoConfig.initIdentityScope(type);

        bookRecordBeanDaoConfig = daoConfigMap.get(BookRecordBeanDao.class).clone();
        bookRecordBeanDaoConfig.initIdentityScope(type);

        bookChapterBeanDao = new BookChapterBeanDao(bookChapterBeanDaoConfig, this);
        collectBookBeanDao = new CollectBookBeanDao(collectBookBeanDaoConfig, this);
        bookRecordBeanDao = new BookRecordBeanDao(bookRecordBeanDaoConfig, this);

        registerDao(BookChapterBean.class, bookChapterBeanDao);
        registerDao(CollectBookBean.class, collectBookBeanDao);
        registerDao(BookRecordBean.class, bookRecordBeanDao);
    }
    
    public void clear() {
        bookChapterBeanDaoConfig.clearIdentityScope();
        collectBookBeanDaoConfig.clearIdentityScope();
        bookRecordBeanDaoConfig.clearIdentityScope();
    }

    public BookChapterBeanDao getBookChapterBeanDao() {
        return bookChapterBeanDao;
    }

    public CollectBookBeanDao getCollectBookBeanDao() {
        return collectBookBeanDao;
    }

    public BookRecordBeanDao getBookRecordBeanDao() {
        return bookRecordBeanDao;
    }

}
