package com.book.novel.readerartifact.ui.bookshelf.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.book.novel.readerartifact.base.gen.CollectBookBeanDao;
import com.book.novel.readerartifact.base.gen.DaoSession;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import com.book.novel.readerartifact.base.gen.BookChapterBeanDao;

/**
 * @author daniel-wang.
 * @describe : 收藏的书籍
 * @date :2018/12/5
 */

@Entity
public class CollectBookBean implements Parcelable {

    @Id
    private String _id; // 本地书籍中，path 的 md5 值作为本地书籍的 id
    private String title;
    private String author;
    private String shortIntro;
    private String cover; // 在本地书籍中，该字段作为本地文件的路径
    private boolean hasCp;
    private int latelyFollower;
    private double retentionRatio;
    //最新更新日期
    private String updated;
    //最新阅读日期
    private String lastRead;
    private int chaptersCount;
    private String lastChapter;
    //是否更新或未阅读
    private boolean isUpdate = true;
    //是否是本地文件
    private boolean isLocal = false;


    @ToMany(referencedJoinProperty = "bookId")
    private List<BookChapterBean> bookChapterList;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1838524404)
    private transient CollectBookBeanDao myDao;


    protected CollectBookBean(Parcel in) {
    }

    @Generated(hash = 230833102)
    public CollectBookBean(String _id, String title, String author, String shortIntro,
                           String cover, boolean hasCp, int latelyFollower, double retentionRatio,
                           String updated, String lastRead, int chaptersCount, String lastChapter,
                           boolean isUpdate, boolean isLocal) {
        this._id = _id;
        this.title = title;
        this.author = author;
        this.shortIntro = shortIntro;
        this.cover = cover;
        this.hasCp = hasCp;
        this.latelyFollower = latelyFollower;
        this.retentionRatio = retentionRatio;
        this.updated = updated;
        this.lastRead = lastRead;
        this.chaptersCount = chaptersCount;
        this.lastChapter = lastChapter;
        this.isUpdate = isUpdate;
        this.isLocal = isLocal;
    }

    @Generated(hash = 1206793539)
    public CollectBookBean() {
    }

    public static final Creator<CollectBookBean> CREATOR = new Creator<CollectBookBean>() {
        @Override
        public CollectBookBean createFromParcel(Parcel in) {
            return new CollectBookBean(in);
        }

        @Override
        public CollectBookBean[] newArray(int size) {
            return new CollectBookBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(this._id);
        dest.writeString(this.title);
        dest.writeString(this.author);
        dest.writeString(this.shortIntro);
        dest.writeString(this.cover);
        dest.writeByte(this.hasCp ? (byte) 1 : (byte) 0);
        dest.writeInt(this.latelyFollower);
        dest.writeDouble(this.retentionRatio);
        dest.writeString(this.updated);
        dest.writeString(this.lastRead);
        dest.writeInt(this.chaptersCount);
        dest.writeString(this.lastChapter);
        dest.writeByte(this.isUpdate ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isLocal ? (byte) 1 : (byte) 0);
    }

    public String get_id() {
        return this._id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getShortIntro() {
        return this.shortIntro;
    }

    public void setShortIntro(String shortIntro) {
        this.shortIntro = shortIntro;
    }

    public String getCover() {
        return this.cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public boolean getHasCp() {
        return this.hasCp;
    }

    public void setHasCp(boolean hasCp) {
        this.hasCp = hasCp;
    }

    public int getLatelyFollower() {
        return this.latelyFollower;
    }

    public void setLatelyFollower(int latelyFollower) {
        this.latelyFollower = latelyFollower;
    }

    public double getRetentionRatio() {
        return this.retentionRatio;
    }

    public void setRetentionRatio(double retentionRatio) {
        this.retentionRatio = retentionRatio;
    }

    public String getUpdated() {
        return this.updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getLastRead() {
        return this.lastRead;
    }

    public void setLastRead(String lastRead) {
        this.lastRead = lastRead;
    }

    public int getChaptersCount() {
        return this.chaptersCount;
    }

    public void setChaptersCount(int chaptersCount) {
        this.chaptersCount = chaptersCount;
    }

    public String getLastChapter() {
        return this.lastChapter;
    }

    public void setLastChapter(String lastChapter) {
        this.lastChapter = lastChapter;
    }

    public boolean getIsUpdate() {
        return this.isUpdate;
    }

    public void setIsUpdate(boolean isUpdate) {
        this.isUpdate = isUpdate;
    }

    public boolean getIsLocal() {
        return this.isLocal;
    }

    public void setIsLocal(boolean isLocal) {
        this.isLocal = isLocal;
    }

    public void setBookChapters(List<BookChapterBean> beans) {
        bookChapterList = beans;
        for (BookChapterBean bean : bookChapterList) {
            bean.setBookId(get_id());
        }
    }

    public List<BookChapterBean> getBookChapters() {
        if (daoSession == null) {
            return bookChapterList;
        } else {
            return getBookChapterList();
        }
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1005693910)
    public List<BookChapterBean> getBookChapterList() {
        if (bookChapterList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BookChapterBeanDao targetDao = daoSession.getBookChapterBeanDao();
            List<BookChapterBean> bookChapterListNew = targetDao
                    ._queryCollectBookBean_BookChapterList(_id);
            synchronized (this) {
                if (bookChapterList == null) {
                    bookChapterList = bookChapterListNew;
                }
            }
        }
        return bookChapterList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1077762221)
    public synchronized void resetBookChapterList() {
        bookChapterList = null;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 320651824)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getCollectBookBeanDao() : null;
    }
}
