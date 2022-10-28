package com.sorabh.grabfood.databinding;
import com.sorabh.grabfood.R;
import com.sorabh.grabfood.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FoodItemCardViewBindingImpl extends FoodItemCardViewBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FoodItemCardViewBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 1, sIncludes, sViewsWithIds));
    }
    private FoodItemCardViewBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.textview.MaterialTextView) bindings[0]
            );
        this.txtFoodItemName.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
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
        if (BR.foodItem == variableId) {
            setFoodItem((com.sorabh.grabfood.api_response_classes.oder_history_response.FoodItem) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setFoodItem(@Nullable com.sorabh.grabfood.api_response_classes.oder_history_response.FoodItem FoodItem) {
        this.mFoodItem = FoodItem;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.foodItem);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
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
        com.sorabh.grabfood.api_response_classes.oder_history_response.FoodItem foodItem = mFoodItem;
        java.lang.String foodItemName = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (foodItem != null) {
                    // read foodItem.name
                    foodItemName = foodItem.getName();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtFoodItemName, foodItemName);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): foodItem
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}