package com.sorabh.grabfood.databinding;
import com.sorabh.grabfood.R;
import com.sorabh.grabfood.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class RestaurantsHomeCardviewBindingImpl extends RestaurantsHomeCardviewBinding implements com.sorabh.grabfood.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final com.google.android.material.card.MaterialCardView mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback3;
    @Nullable
    private final android.view.View.OnClickListener mCallback2;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public RestaurantsHomeCardviewBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private RestaurantsHomeCardviewBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (androidx.appcompat.widget.AppCompatImageButton) bindings[5]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[1]
            , (com.google.android.material.textview.MaterialTextView) bindings[2]
            , (com.google.android.material.textview.MaterialTextView) bindings[3]
            , (com.google.android.material.textview.MaterialTextView) bindings[4]
            );
        this.cardViewImgBtnFavorite.setTag(null);
        this.cardViewImgRestaurant.setTag(null);
        this.cardViewTxtName.setTag(null);
        this.cardViewTxtPrice.setTag(null);
        this.cardViewTxtRating.setTag(null);
        this.mboundView0 = (com.google.android.material.card.MaterialCardView) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        mCallback3 = new com.sorabh.grabfood.generated.callback.OnClickListener(this, 2);
        mCallback2 = new com.sorabh.grabfood.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.onFavoriteButtonClicked == variableId) {
            setOnFavoriteButtonClicked((com.sorabh.grabfood.ui.adapter.RestaurantViewHolder.OnFavoriteButtonClicked) variable);
        }
        else if (BR.onRestaurantClicked == variableId) {
            setOnRestaurantClicked((com.sorabh.grabfood.ui.adapter.RestaurantViewHolder.OnRestaurantsClicked) variable);
        }
        else if (BR.view == variableId) {
            setView((com.sorabh.grabfood.databinding.RestaurantsHomeCardviewBindingImpl) variable);
        }
        else if (BR.data == variableId) {
            setData((com.sorabh.grabfood.domain.model.reataurants_home_response.Dish) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setOnFavoriteButtonClicked(@Nullable com.sorabh.grabfood.ui.adapter.RestaurantViewHolder.OnFavoriteButtonClicked OnFavoriteButtonClicked) {
        this.mOnFavoriteButtonClicked = OnFavoriteButtonClicked;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.onFavoriteButtonClicked);
        super.requestRebind();
    }
    public void setOnRestaurantClicked(@Nullable com.sorabh.grabfood.ui.adapter.RestaurantViewHolder.OnRestaurantsClicked OnRestaurantClicked) {
        this.mOnRestaurantClicked = OnRestaurantClicked;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.onRestaurantClicked);
        super.requestRebind();
    }
    public void setView(@Nullable com.sorabh.grabfood.databinding.RestaurantsHomeCardviewBindingImpl View) {
        this.mView = View;
    }
    public void setData(@Nullable com.sorabh.grabfood.domain.model.reataurants_home_response.Dish Data) {
        this.mData = Data;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.data);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeView((com.sorabh.grabfood.databinding.RestaurantsHomeCardviewBindingImpl) object, fieldId);
        }
        return false;
    }
    private boolean onChangeView(com.sorabh.grabfood.databinding.RestaurantsHomeCardviewBindingImpl View, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        com.sorabh.grabfood.ui.adapter.RestaurantViewHolder.OnFavoriteButtonClicked onFavoriteButtonClicked = mOnFavoriteButtonClicked;
        java.lang.String dataImageUrl = null;
        java.lang.String dataCostForOne = null;
        com.sorabh.grabfood.ui.adapter.RestaurantViewHolder.OnRestaurantsClicked onRestaurantClicked = mOnRestaurantClicked;
        java.lang.String dataRating = null;
        java.lang.String dataName = null;
        com.sorabh.grabfood.domain.model.reataurants_home_response.Dish data = mData;

        if ((dirtyFlags & 0x18L) != 0) {



                if (data != null) {
                    // read data.image_url
                    dataImageUrl = data.getImage_url();
                    // read data.cost_for_one
                    dataCostForOne = data.getCost_for_one();
                    // read data.rating
                    dataRating = data.getRating();
                    // read data.name
                    dataName = data.getName();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x10L) != 0) {
            // api target 1

            this.cardViewImgBtnFavorite.setOnClickListener(mCallback3);
            this.mboundView0.setOnClickListener(mCallback2);
        }
        if ((dirtyFlags & 0x18L) != 0) {
            // api target 1

            com.sorabh.grabfood.util.binding_adapter.BindingAdapterKt.imgSrcUrl(this.cardViewImgRestaurant, dataImageUrl);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.cardViewTxtName, dataName);
            com.sorabh.grabfood.util.binding_adapter.BindingAdapterKt.txt(this.cardViewTxtPrice, dataCostForOne);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.cardViewTxtRating, dataRating);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 2: {
                // localize variables for thread safety
                // onFavoriteButtonClicked
                com.sorabh.grabfood.ui.adapter.RestaurantViewHolder.OnFavoriteButtonClicked onFavoriteButtonClicked = mOnFavoriteButtonClicked;
                // data
                com.sorabh.grabfood.domain.model.reataurants_home_response.Dish data = mData;
                // onFavoriteButtonClicked != null
                boolean onFavoriteButtonClickedJavaLangObjectNull = false;



                onFavoriteButtonClickedJavaLangObjectNull = (onFavoriteButtonClicked) != (null);
                if (onFavoriteButtonClickedJavaLangObjectNull) {



                    onFavoriteButtonClicked.onFavoriteButtonClicked(data);
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // onRestaurantClicked != null
                boolean onRestaurantClickedJavaLangObjectNull = false;
                // onRestaurantClicked
                com.sorabh.grabfood.ui.adapter.RestaurantViewHolder.OnRestaurantsClicked onRestaurantClicked = mOnRestaurantClicked;
                // data
                com.sorabh.grabfood.domain.model.reataurants_home_response.Dish data = mData;



                onRestaurantClickedJavaLangObjectNull = (onRestaurantClicked) != (null);
                if (onRestaurantClickedJavaLangObjectNull) {



                    onRestaurantClicked.onRestaurantsClicked(data);
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): view
        flag 1 (0x2L): onFavoriteButtonClicked
        flag 2 (0x3L): onRestaurantClicked
        flag 3 (0x4L): data
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}